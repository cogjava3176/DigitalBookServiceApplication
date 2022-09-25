import {Author} from "./author.model";
import {Category} from "./category.model";

export class Book {
  id?: number
  logo?: string
  title?: string
  category?: Category
  price?: number
  author: Author = new Author()
  publisher?: string
  publishedDate?: Date
  content?: string
  active?: boolean = false

}
