import {Component, OnInit} from '@angular/core';
import {Book} from "../model/book.model";
import {Category} from "../model/category.model";
import {BookService} from "../service/book.service";
import {NotificationService} from "../service/notification.service";

@Component({
  selector: 'app-search-book',
  templateUrl: './search-book.component.html',
  styleUrls: ['./search-book.component.scss']
})
export class SearchBookComponent implements OnInit {

  constructor(private bookService: BookService,
              private notificationService: NotificationService) {
  }

  ngOnInit(): void {
    this.search()
    // this.author = 'author 1'
    // this.publisher = 'publisher 1'
    // this.category = 'AutoBiography'
    // this.price = 10000
  }

  categories: Category[] = Object.values(Category)

  category?: string
  author?: string
  publisher?: string
  price?: number
  searchResult: Book[] = []
  displayedColumns: string[] = ['Title', 'Category', 'Logo', 'Author', 'Price', 'Publisher', 'Publish Date', 'Active', 'Content'];

  search() {
    this.bookService.search(this.category, this.author, this.publisher, this.price).subscribe(value => {
        this.searchResult = value
      },
      error => {
        this.notificationService.error("Opp...Something wrong!")
      })
  }

  buy(book: Book) {
    this.notificationService.success('Buy book: ' + book.title + ' successfully')
  }
}
