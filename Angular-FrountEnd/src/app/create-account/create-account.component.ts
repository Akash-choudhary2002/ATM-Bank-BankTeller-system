import { Component } from '@angular/core';
import { AccountService } from '../account.service';
import { Account } from '../account';

import { FormsModule } from '@angular/forms';
@Component({
  selector: 'app-create-account',
    standalone:true,
    imports: [FormsModule],

  templateUrl: './create-account.component.html',
  styleUrl: './create-account.component.css'
  


})
export class CreateAccountComponent {
      
  account: Account = new Account();

  constructor(private accountService: AccountService) {}
     
  onsubmit() {
    this.saveAccount();
     console.log(this.account);
    // this.accountService.addAccount(this.account).subscribe(
    //   (response: Account) => {
    //     console.log('Account created:', response);
    //   }
      // (error: any) => {
      //   console.error('Error creating account:', error);
      // }
//);//
  }  
  saveAccount() {
    this.accountService.addAccount(this.account).subscribe(data=>{
      console.log(data);
    })
  };
}