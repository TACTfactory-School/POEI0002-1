import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import {PageEvent, MatPaginator} from '@angular/material/paginator';
import { Pageable } from './pageable';

const pageSizeOptions = [12, 24, 48, 96];

interface PaginatorOptions {
  page: number;
  perPage: number;
  pageSizeOptions: number[];
}

@Component({
  selector: 'app-paginator',
  templateUrl: './paginator.component.html',
  styleUrls: ['./paginator.component.scss']
})
export class PaginatorComponent implements OnInit {

  readonly options: PaginatorOptions = {
    page: 0,
    perPage: 12,
    pageSizeOptions
  };

  @Input() readonly totalElements: number = null;

  @Output() page = new EventEmitter<Pageable>();

  constructor() { }

  ngOnInit() {
    this.page.emit(this.options);
  }

  onPaginate(p: MatPaginator) {
    this.page.emit({
      page: p.pageIndex,
      perPage: p.pageSize
    })
  }
}
