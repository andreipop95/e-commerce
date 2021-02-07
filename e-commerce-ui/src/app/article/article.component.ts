import { Component, OnInit } from '@angular/core';
import { AddOrderItemDTO } from '../dtos/addOrderItemDTO';
import { ArticleDTO } from '../dtos/articleDTO';
import { OrderDTO } from '../dtos/orderDTO';
import { ArticleApiService } from '../services/article-api.service';
import { OrderApiService } from '../services/order-api.service';

@Component({
  selector: 'app-article',
  templateUrl: './article.component.html',
  styleUrls: ['./article.component.css']
})
export class ArticleComponent implements OnInit {

  public articles: ArticleDTO[] = [];
  public articleMap = new Map<number, ArticleDTO>();

  private inProgressOrder!: OrderDTO;
  public errorDescription = '';

  constructor(private articleApiService: ArticleApiService,
              private orderApiService: OrderApiService) { }

  ngOnInit(): void {
    this.articleApiService.getArticles().subscribe(fetchedArticles => {
      this.articles = fetchedArticles;
      this.articles.map(article => this.articleMap.set(article.id, article));
    });
    this.orderApiService.getInProgressOrder()
      .subscribe(order => {
        this.inProgressOrder = order;
        console.log(this.inProgressOrder);
      });
  }

  public addToCart(article: ArticleDTO, quantity: string): void {
    this.orderApiService.addItemToOrder(
      {
        articleId: article.id,
        quantity: +quantity
    } as AddOrderItemDTO, this.inProgressOrder.id)
      .subscribe(
        () => {},
        error => {
          this.errorDescription = error.message;
        }
      );
  }

}
