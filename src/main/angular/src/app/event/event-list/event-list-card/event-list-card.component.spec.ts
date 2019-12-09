import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { EventListCardComponent } from './event-list-card.component';
import { MatCardModule } from '@angular/material';

describe('EventListCardComponent', () => {
  let component: EventListCardComponent;
  let fixture: ComponentFixture<EventListCardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [
        EventListCardComponent
       ],
       imports: [
         MatCardModule
       ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EventListCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
