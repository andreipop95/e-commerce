import { Injectable } from '@angular/core';
import { OrderDTO } from '../dtos/orderDTO';
import { OrderApiService } from './order-api.service';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  private $orderInProgress!: OrderDTO;

  constructor(private orderApiService: OrderApiService) {
    this.orderApiService.getInProgressOrder()
      .subscribe(order => {
        this.$orderInProgress = order;
      });
  }

  get orderInProgress(): OrderDTO {
    return this.$orderInProgress;
  }
}
