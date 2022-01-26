import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HackerNewsComponent } from './hacker-news.component';

describe('HackerNewsComponent', () => {
  let component: HackerNewsComponent;
  let fixture: ComponentFixture<HackerNewsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HackerNewsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HackerNewsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
