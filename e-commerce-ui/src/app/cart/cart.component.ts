import { Component, OnInit } from '@angular/core';
import { ArticleDTO } from '../dtos/articleDTO';
import { OrderDTO } from '../dtos/orderDTO';
import { OrderItemDTO } from '../dtos/orderItemDTO';
import { OrderApiService } from '../services/order-api.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  public shoppingCart!: OrderDTO;

  constructor(private orderApiService: OrderApiService) { }

  ngOnInit(): void {
    this.orderApiService.getInProgressOrder()
      .subscribe(order => {
        this.shoppingCart = order;
      });
  }

  public removeOrderItem(orderItem: OrderItemDTO): void {
    this.orderApiService.removeItemFromOrder(orderItem.id, this.shoppingCart.id)
      .subscribe(updatedOrder => this.shoppingCart = updatedOrder);
  }
}
