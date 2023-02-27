import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShopItemTemplateComponent } from './shop-item-template.component';

describe('ShopItemTemplateComponent', () => {
  let component: ShopItemTemplateComponent;
  let fixture: ComponentFixture<ShopItemTemplateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ShopItemTemplateComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ShopItemTemplateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
