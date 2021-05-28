import { ComponentFixture, TestBed } from '@angular/core/testing';
import { FootballPointsListComponent } from './football-points-list.component';

describe('FootballPointsListComponent', () => {
  let component: FootballPointsListComponent;
  let fixture: ComponentFixture<FootballPointsListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FootballPointsListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FootballPointsListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
