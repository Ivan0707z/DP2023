import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShopItemsSectionComponent } from './shop-items-section.component';

describe('ShopItemsSectionComponent', () => {
  let component: ShopItemsSectionComponent;
  let fixture: ComponentFixture<ShopItemsSectionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ShopItemsSectionComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ShopItemsSectionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
