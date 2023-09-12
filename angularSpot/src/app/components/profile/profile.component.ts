import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { User } from 'src/app/models/user';
import { AuthService } from 'src/app/services/auth.service';
import { ProfileService } from 'src/app/services/profile.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  user: User = new User();
  selected: User | null = null;
  username: string = '';
  editUser: User | null = null;
  checkedUser: boolean = false;

  constructor(
    private auth: AuthService,
    private route: ActivatedRoute,
    private router: Router,
    private profileService: ProfileService,

  ) { }

  ngOnInit() {
    this.getLoggedInUserInfo();
  }

  getLoggedInUserInfo(): Observable<User> | null {

    return null;
  }



}
