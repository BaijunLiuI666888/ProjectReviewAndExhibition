import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ApiEditPage } from './api-edit.page';

describe('ApiEditPage', () => {
  let component: ApiEditPage;
  let fixture: ComponentFixture<ApiEditPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ApiEditPage ],
      schemas: [CUSTOM_ELEMENTS_SCHEMA],
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ApiEditPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
