import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DonateComponent } from './donate.component';

describe('DonateComponent', () => {
  let component: DonateComponent;
  let fixture: ComponentFixture<DonateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DonateComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DonateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
