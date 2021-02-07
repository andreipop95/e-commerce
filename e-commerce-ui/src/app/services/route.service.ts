import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class RouteService {

  constructor() { }

  private baseUrl = 'http://localhost:8082';
  private articlesApiUrl = 'article';
  private create = 'create';
  private orderApi = 'order';
  private inProgressOrder = 'inProgressOrder';
  private addItem = 'addItem';

  get articleApiUrl(): string {
    return this.baseUrl + '/' + this.articlesApiUrl;
  }

  get saveArticleUrl(): string {
    return this.articleApiUrl + '/' + this.create;
  }

  get orderApiUrl(): string {
    return this.baseUrl + '/' + this.orderApi;
  }

  get inProgressOrderUrl(): string {
    return this.orderApiUrl + '/' + this.inProgressOrder;
  }

  get addItemToOrderUrl(): string {
    return this.orderApiUrl + '/' + this.addItem;
  }
}
