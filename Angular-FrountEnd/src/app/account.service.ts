import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Account } from './account';

@Injectable({
  providedIn: 'root'
})
export class AccountService {

  private baseUrl = "http://localhost:8080/apii/accounts"
 
  constructor(private httpClient: HttpClient) { 
    console.log('Accounts:', this.baseUrl);
  }
    
 
 getAllAccounts(): Observable<Account[]> {

    return this.httpClient.get<Account[]>(`${this.baseUrl}`);
  }
   
  addAccount(account: Account): Observable<Account> {
    return this.httpClient.post<Account>(`${this.baseUrl}`, account);
  }
}
