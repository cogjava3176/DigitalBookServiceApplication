import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {Author} from "../model/author.model";
import {Book} from "../model/book.model";
import {Category} from "../model/category.model";
import {BookService} from "../service/book.service";
import {NotificationService} from "../service/notification.service";

@Component({
  selector: 'app-create-book',
  templateUrl: './create-book.component.html',
  styleUrls: ['./create-book.component.scss']
})
export class CreateBookComponent implements OnInit {

  book: Book = new Book()

  categories: Category[] = Object.values(Category)

  constructor(private bookService: BookService,
              private router: Router,
              private notificationService: NotificationService) {

  }

  ngOnInit(): void {
    // this.book.active = true
    // this.book.content = 'book content'
    // this.book.logo = 'logo 1'
    // this.book.publisher = 'publisher 1'
    // this.book.price = 10000
    // this.book.title = 'book 1'
    // this.book.author = new Author()
    // this.book.author.name = 'Author 2'
    // this.book.category = Category.AutoBiography
    // this.book.publishedDate = new Date()
  }

  save() {
    this.bookService.save(this.book).subscribe(value => {
      this.notificationService.success("Create book: " + value.title + ' successfully')
      this.router.navigate(['search-book'])
    }, error => {
      this.notificationService.success("Something went wrong!")
    })
  }
}
