export interface Page<T> {
  totalPage: number;
  totalElements: number;
  size: number;
  content: T[];
}
