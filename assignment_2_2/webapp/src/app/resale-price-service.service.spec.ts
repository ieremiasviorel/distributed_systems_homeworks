import { TestBed, inject } from '@angular/core/testing';

import { ResalePriceServiceService } from './resale-price-service.service';

describe('ResalePriceServiceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ResalePriceServiceService]
    });
  });

  it('should be created', inject([ResalePriceServiceService], (service: ResalePriceServiceService) => {
    expect(service).toBeTruthy();
  }));
});
