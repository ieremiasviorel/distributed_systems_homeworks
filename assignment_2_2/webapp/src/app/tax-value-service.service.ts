import { Injectable } from '@angular/core';
import { HttpParams, HttpClient } from '@angular/common/http';
import { Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TaxValueServiceService {

  constructor(private httpClient: HttpClient) { }

  public computeTaxValue(engineSize: number): Observable<number> {
    var requestUrl: string = 'http://localhost:8080/assignment_2_2.client/tax-value';
    var requestParams: HttpParams = new HttpParams().set('engineSize', engineSize.toString());
    var requestOptions: Object = {
      params: requestParams,
      responseType: 'text'
    }
    return this.httpClient.get<number>(requestUrl, requestOptions);
  }
}
