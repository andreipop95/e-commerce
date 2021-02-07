import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatToolbarModule } from '@angular/material/toolbar';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NoopAnimationsModule } from '@angular/platform-browser/animations';
import { MenuBarComponent } from './menu-bar/menu-bar.component';
import { ArticleComponent } from './article/article.component';
import { CartComponent } from './cart/cart.component';
import { OrderComponent } from './order/order.component';
import { AddArticleComponent } from './add-article/add-article.component';

@NgModule({
  declarations: [
    AppComponent,
    MenuBarComponent,
    ArticleComponent,
    CartComponent,
    OrderComponent,
    AddArticleComponent
  ],
    imports: [
      BrowserModule,
      AppRoutingModule,
      NoopAnimationsModule,
      MatToolbarModule,
      MatButtonModule,
      MatCardModule,
      HttpClientModule,
      ReactiveFormsModule,
      MatFormFieldModule,
      MatInputModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
