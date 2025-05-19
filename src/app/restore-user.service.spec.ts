import { TestBed } from '@angular/core/testing';

import { RestoreUserService } from './restore-user.service';

describe('RestoreUserService', () => {
  let service: RestoreUserService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RestoreUserService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
