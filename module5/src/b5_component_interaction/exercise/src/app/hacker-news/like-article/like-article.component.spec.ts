import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LikeArticleComponent } from './like-article.component';

describe('LikeArticleComponent', () => {
  let component: LikeArticleComponent;
  let fixture: ComponentFixture<LikeArticleComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LikeArticleComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LikeArticleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
