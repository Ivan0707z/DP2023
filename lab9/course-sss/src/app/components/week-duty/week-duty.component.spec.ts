import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WeekDutyComponent } from './week-duty.component';

describe('WeekDutyComponent', () => {
  let component: WeekDutyComponent;
  let fixture: ComponentFixture<WeekDutyComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WeekDutyComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(WeekDutyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
