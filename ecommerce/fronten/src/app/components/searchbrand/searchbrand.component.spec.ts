import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchbrandComponent } from './searchbrand.component';

describe('SearchbrandComponent', () => {
  let component: SearchbrandComponent;
  let fixture: ComponentFixture<SearchbrandComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SearchbrandComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchbrandComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
