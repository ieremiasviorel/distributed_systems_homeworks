import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpParams, HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ResalePriceServiceService {

  constructor(private httpClient: HttpClient) { }

  public computeResalePrice(purchasePrice: number, productionYear: number): Observable<number> {
    var requestUrl: string = 'http://localhost:8080/assignment_2_2.client/resale-price';
    var requestParams: HttpParams = new HttpParams()
      .set('purchasePrice', purchasePrice.toString())
      .set('productionYear', productionYear.toString());
    var requestOptions: Object = {
      params: requestParams,
      responseType: 'text'
    }
    return this.httpClient.get<number>(requestUrl, requestOptions);
  }
}
