import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ApiDetailPage } from './api-detail.page';

describe('ApiDetailPage', () => {
  let component: ApiDetailPage;
  let fixture: ComponentFixture<ApiDetailPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ApiDetailPage ],
      schemas: [CUSTOM_ELEMENTS_SCHEMA],
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ApiDetailPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
