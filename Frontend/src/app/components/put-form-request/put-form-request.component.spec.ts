import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PutFormRequestComponent } from './put-form-request.component';

describe('PutFormRequestComponent', () => {
  let component: PutFormRequestComponent;
  let fixture: ComponentFixture<PutFormRequestComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PutFormRequestComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PutFormRequestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
