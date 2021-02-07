import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AddOrderItemDTO } from '../dtos/addOrderItemDTO';
import { RouteService } from './route.service';

@Injectable({
  providedIn: 'root'
})
export class OrderApiService {

  constructor(private http: HttpClient,
              private routeService: RouteService) { }

  getInProgressOrder(): Observable<any> {
    return this.http.get(this.routeService.inProgressOrderUrl);
  }

  addItemToOrder(orderItem: AddOrderItemDTO, orderId: number): Observable<any> {
    return this.http.post(this.routeService.addItemToOrderUrl + '/' + orderId, orderItem);
  }

  removeItemFromOrder(itemId: number, orderId: number): Observable<any> {
    return this.http.delete(this.routeService.orderApiUrl + '/' + itemId + '/' + orderId);
  }
}
