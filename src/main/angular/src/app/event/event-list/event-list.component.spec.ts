import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EventListComponent } from './event-list.component';
import { MatCardModule, MatTableModule, MatPaginatorModule, MatTooltipModule } from '@angular/material';
import { EventListToggleComponent } from './event-list-toggle/event-list-toggle.component';
import { EventListInlineComponent } from './event-list-inline/event-list-inline.component';
import { EventListCardComponent } from './event-list-card/event-list-card.component';
import { HttpClientModule } from '@angular/common/http';
import { MaterialModule } from 'src/app/shared/material/material.module';
import { SharedModule } from 'src/app/shared/shared.module';
import { RouterModule } from '@angular/router';
import { PaginatorModule } from 'src/app/shared/paginator/paginator.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

describe('EventListComponent', () => {
  let component: EventListComponent;
  let fixture: ComponentFixture<EventListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [
        // EventListToggleComponent,
        // EventListInlineComponent,
        // EventListCardComponent
      ],
      imports: [
        HttpClientModule,
        MatCardModule,
        MaterialModule,
        MatPaginatorModule,
        MatTableModule,
        SharedModule,
        RouterModule.forRoot([]),
        PaginatorModule,
        MatTooltipModule,
        BrowserAnimationsModule

      ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EventListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
