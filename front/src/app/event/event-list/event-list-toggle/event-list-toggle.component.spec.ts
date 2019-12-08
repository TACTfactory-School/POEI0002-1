import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { EventListToggleComponent } from './event-list-toggle.component';
import { MatIconModule, MatButtonToggleModule } from '@angular/material';
import { MaterialModule } from 'src/app/shared/material/material.module';

describe('EventListToggleComponent', () => {
  let component: EventListToggleComponent;
  let fixture: ComponentFixture<EventListToggleComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [
        EventListToggleComponent
      ],
      imports: [
        MaterialModule
      ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EventListToggleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
