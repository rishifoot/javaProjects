import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CheckserComponent } from './checkser.component';

describe('CheckserComponent', () => {
  let component: CheckserComponent;
  let fixture: ComponentFixture<CheckserComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CheckserComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CheckserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
