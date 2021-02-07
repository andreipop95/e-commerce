import { AddressDTO } from './addressDTO';
import { OrderItemDTO } from './orderItemDTO';

export interface OrderDTO {
  id: number;
  orderItems: OrderItemDTO[];
  subtotal: number;
  address: AddressDTO;
}
