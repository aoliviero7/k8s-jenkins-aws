import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class ClusterServiceService {

  baseUrl : string = "http://k8s-tesi-ingressd-aaaf8da16c-165805739.eu-west-1.elb.amazonaws.com";
  baseUrlLambda: string = "https://yj8lzqyhm8.execute-api.eu-west-1.amazonaws.com/prod/hello";

  constructor(
    private httpClient: HttpClient,
  ) { }

  getHttpOptions() {
    let httpOptions = {
      headers: new HttpHeaders(),
    };
    return httpOptions;
  }

  getBucketList(): Observable<any> {
    return this.httpClient.get(
      this.baseUrl + '/test2/listbucket',
      {responseType: 'json'}
    );
  }

  getImageByBucket(name: String): Observable<any> {
    return this.httpClient.get(
      this.baseUrl + '/test2/bucket/'+name,
      {responseType: 'blob'}
    );
  }

  getUser(): Observable<User[]> {
    return this.httpClient.get<User[]>(
      this.baseUrl + '/data/tableTest',
      {responseType: 'json'}
    );
  }

  getLambda(): Observable<any> {
    return this.httpClient.get(
      this.baseUrlLambda,
      {responseType: 'text'}
    );
  }


}
