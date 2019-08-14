import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ApiTagPostsPage } from './api-tag-posts.page';

describe('ApiTagPostsPage', () => {
  let component: ApiTagPostsPage;
  let fixture: ComponentFixture<ApiTagPostsPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ApiTagPostsPage ],
      schemas: [CUSTOM_ELEMENTS_SCHEMA],
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ApiTagPostsPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
