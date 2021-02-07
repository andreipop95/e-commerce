import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddArticleComponent } from './add-article/add-article.component';
import { ArticleComponent } from './article/article.component';
import { CartComponent } from './cart/cart.component';
import { OrderComponent } from './order/order.component';

const routes: Routes = [
  {
    path: '',
    component: ArticleComponent,
    pathMatch: 'full',
  },
  {
    path: 'cart',
    component: CartComponent,
    pathMatch: 'full',
  },
  {
    path: 'orders',
    component: OrderComponent,
    pathMatch: 'full',
  },
  {
    path: 'addArticles',
    component: AddArticleComponent,
    pathMatch: 'full'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
