export class User {
  id: number;
  firstName: string;
  lastName: string;
  email: string;
  password: string;
  enabled: boolean;
  role: string;
  username: string;
  joinDate: string;
  post: any[] | null;
  comments: any[] | null;

  constructor(
    id: number =0,
    firstName: string= '',
    lastName: string = '',
    email: string='',
    password: string='',
    enabled: boolean = false,
    role: string='',
    username: string = '',
    joinDate: string='',
    post: any[] =[],
    comments: any[] =[]
  ){
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.password = password;
    this.enabled = enabled;
    this.role = role;
    this.username = username;
    this.joinDate = joinDate;
    this.post= post;
    this.comments = comments;
  }
}
