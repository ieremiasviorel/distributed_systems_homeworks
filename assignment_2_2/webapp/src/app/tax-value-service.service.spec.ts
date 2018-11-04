import { TestBed, inject } from '@angular/core/testing';

import { TaxValueServiceService } from './tax-value-service.service';

describe('TaxValueServiceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [TaxValueServiceService]
    });
  });

  it('should be created', inject([TaxValueServiceService], (service: TaxValueServiceService) => {
    expect(service).toBeTruthy();
  }));
});
