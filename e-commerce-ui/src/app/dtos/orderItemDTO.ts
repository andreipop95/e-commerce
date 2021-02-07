import { ArticleDTO } from './articleDTO';

export interface OrderItemDTO {
  id: number;
  articleDTO: ArticleDTO;
  quantity: number;
}
