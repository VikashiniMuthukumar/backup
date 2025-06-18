import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/service/login service/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  isLogin = true;

  loginData = { username: '', password: '' };
  registerData = { username: '', newPassword: '', confirmPassword: '' };

  //constructor(private loginService: LoginService, private router: Router) {}
  constructor(private loginService: LoginService) {}

  toggleForm() {
    this.isLogin = !this.isLogin;
  }
 login() {
     const payload = {
       username: this.loginData.username.trim(),
       password: this.loginData.password.trim()
     };

     this.loginService.login(payload).subscribe({
       next: res => alert(res),
       error: err => alert('Login failed: ' + err.error)
     });
   }

//   login() {
//   const payload = {
//     username: this.loginData.username.trim(),
//     password: this.loginData.password.trim()
//   };

//   this.loginService.login(payload).subscribe({
//     next: res => {
//       alert(res);
//       this.router.navigate(['/main']); // ✅ Navigate to Main Dashboard
//     },
//     error: err => alert('Login failed: ' + err.error)
//   });
// }


  register() {
    if (this.registerData.newPassword !== this.registerData.confirmPassword) {
      alert("Passwords do not match.");
      return;
    }

    const payload = {
      username: this.registerData.username.trim(),
      password: this.registerData.newPassword.trim()
    };

    this.loginService.register(payload).subscribe({
      next: res => alert(res),
      error: err => {
        if (err.status === 409) {
          alert('User already exists');
        } else {
          alert('Registration failed');
        }
      }
    });
  }
}
