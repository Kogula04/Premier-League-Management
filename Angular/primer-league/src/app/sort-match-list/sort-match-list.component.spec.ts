import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SortMatchListComponent } from './sort-match-list.component';

describe('SortMatchListComponent', () => {
  let component: SortMatchListComponent;
  let fixture: ComponentFixture<SortMatchListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SortMatchListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SortMatchListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
