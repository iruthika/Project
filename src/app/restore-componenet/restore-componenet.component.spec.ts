import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RestoreComponenetComponent } from './restore-componenet.component';

describe('RestoreComponenetComponent', () => {
  let component: RestoreComponenetComponent;
  let fixture: ComponentFixture<RestoreComponenetComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RestoreComponenetComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RestoreComponenetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
