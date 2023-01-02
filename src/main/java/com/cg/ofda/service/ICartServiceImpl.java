package com.cg.ofda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ofda.dto.FoodCartDto;
import com.cg.ofda.dto.ItemDto;
import com.cg.ofda.exception.CartException;
import com.cg.ofda.repository.ICartRepository;
import com.cg.ofda.repository.IItemRepository;

@Service
public class ICartServiceImpl implements ICartService{
	@Autowired
	ICartRepository cartRepository;
	@Autowired
	IItemRepository itemRepository;
	
	
	/* @author : Usha
	 * @return : true 
	 * @description : This method is to add to cart.
	 */
	@Override
	public FoodCartDto addItemToCart(String cartId, ItemDto item) throws CartException{
		if(cartRepository.existsById(cartId)) {
		FoodCartDto cart = cartRepository.findById(cartId).get();
		List<ItemDto> items = cart.getItemList();
		items.add(item);
		return cartRepository.save(cart);
		}
		else
			throw new CartException("Cart Id not found");
	}
	

	/* @author : Usha
	 * @return : true 
	 * @description : This method is to view cart by id..
	 */
	public FoodCartDto viewCartById(String cartId) {
		return cartRepository.findById(cartId).get();
	}


	/* @author : Usha
	 * @return : true 
	 * @description : This method is to clear the cart.
	 */
	@Override
	public FoodCartDto clearCart(String cartId) throws CartException{
		if(cartRepository.existsById(cartId)) {
			FoodCartDto cart = cartRepository.findById(cartId).get();
			cartRepository.delete(cart);
			return cart;
		}
		else throw new CartException("Cart Id not found");
	}


	/* @author : Usha
	 * @return : true 
	 * @description : This method is to view the  cart.
	 */
	@Override
	public List<FoodCartDto> viewCart() {
		return cartRepository.findAll();
	}


	/* @author : Usha
	 * @return : true 
	 * @description : This method is to increase quantity of food item.
	 */
	@Override
	public FoodCartDto increaseQuantity(String cartId, String itemId, int quantity) throws CartException{
		ItemDto it = null;
		if(cartRepository.existsById(cartId)) {
		FoodCartDto cart = cartRepository.findById(cartId).get();
		List<ItemDto> items = cart.getItemList();
		for(ItemDto item : items) {
			if(item.getItemId().equals(itemId))
			 it = item;
		}
		int qty = it.getQuantity();
		it.setQuantity(quantity+qty);
		cartRepository.save(cart);
		return cart;	
		}
		else
			throw new CartException("Cart Id not found");
	}
	

	/* @author : Usha
	 * @return : true 
	 * @description : This method is to reduce quantity of food item.
	 */
	@Override
	public FoodCartDto reduceQuantity(String cartId, String itemId, int quantity) throws CartException {
		ItemDto it = null;
		if(cartRepository.existsById(cartId)) {
		FoodCartDto cart = cartRepository.findById(cartId).get();
		List<ItemDto> items = cart.getItemList();
		for(ItemDto item : items) {
			if(item.getItemId().equals(itemId))
			 it = item;
		}
		int qty = it.getQuantity();
		it.setQuantity(qty - quantity);
		cartRepository.save(cart);
		return cart;
		}
		else
			throw new CartException("Cart Id not found");
	}
	

	/* @author : Usha
	 * @return : true 
	 * @description : This method is to remove item of cart.
	 */
	public FoodCartDto removeItem(String cartId, String itemId) throws CartException {
		if(cartRepository.existsById(cartId)) {
			FoodCartDto cart = cartRepository.findById(cartId).get();
			List<ItemDto> items = cart.getItemList();
			ItemDto it = null;
			for(ItemDto item : items) {
				if(item.getItemId().equals(itemId)) {
					it = item;
				}
			}
			itemRepository.delete(it);
			cartRepository.save(cart);
			return cart;
		}
		else throw new CartException("Cart Id not found");
		
	}

}

