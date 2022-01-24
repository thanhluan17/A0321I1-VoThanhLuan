import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CountdownTimerEventGetSetComponent } from './countdown-timer-event-get-set.component';

describe('CountdownTimerEventGetSetComponent', () => {
  let component: CountdownTimerEventGetSetComponent;
  let fixture: ComponentFixture<CountdownTimerEventGetSetComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CountdownTimerEventGetSetComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CountdownTimerEventGetSetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
