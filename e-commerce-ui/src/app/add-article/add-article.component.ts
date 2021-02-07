import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { ArticleDTO } from '../dtos/articleDTO';
import { ArticleApiService } from '../services/article-api.service';

@Component({
  selector: 'app-add-article',
  templateUrl: './add-article.component.html',
  styleUrls: ['./add-article.component.css']
})
export class AddArticleComponent {

  constructor(private formBuilder: FormBuilder,
              private articleApiService: ArticleApiService) { }

  public articleForm = this.formBuilder.group({
    name: [''],
    price: [''],
    description: [''],
    availableStock: ['']
  });

  public submitArticle(values: any): void {
    this.articleApiService.saveArticle(values as ArticleDTO)
      .subscribe(() =>
        this.articleForm.reset({
          name: '',
          price: '',
          description: '',
          availableStock: ''
        }));
  }
}
