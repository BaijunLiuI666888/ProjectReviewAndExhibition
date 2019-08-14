import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ApiListPage } from './api-list.page';

describe('ApiListPage', () => {
  let component: ApiListPage;
  let fixture: ComponentFixture<ApiListPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ApiListPage ],
      schemas: [CUSTOM_ELEMENTS_SCHEMA],
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ApiListPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
