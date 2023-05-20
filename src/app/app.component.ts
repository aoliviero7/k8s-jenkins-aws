import { Component, OnInit, Pipe, PipeTransform, ViewChild } from '@angular/core';
import { DomSanitizer, SafeResourceUrl } from '@angular/platform-browser';
import { Subject } from 'rxjs';
import { ClusterServiceService } from './cluster-service.service';
import { User } from './user';




@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  

  title = 'EKS Microservices app TESI';
  listaBucket: String[] = [];
  dtOptions: any;
  dtTrigger: Subject<any> = new Subject<any>();
  imageUrl: any;
  user: User[] = [];
  lambdaString: any;

constructor(
  private clusterService: ClusterServiceService
) {

}



ngOnInit(): void {
}

getBucketList() {
  this.clusterService.getBucketList().subscribe((data)=>{
    this.listaBucket = data;
    console.log(this.listaBucket);
    for(let i = 0; i<this.listaBucket.length; i++) {
      console.log(this.listaBucket[i])
    }
  })
}

getImage(name : String) {
  this.clusterService.getImageByBucket(name).subscribe((imageBlob: Blob)=>{
    this.imageUrl = window.URL.createObjectURL(imageBlob);
    
  })
}

getUser() {
  this.clusterService.getUser().subscribe((data)=>{
    this.user = data;
    //console.log(data);
    for(let i = 0; i<this.user.length; i++) {
      console.log(this.user[i])
    }
  })
}

getLambda()  {
  this.clusterService.getLambda().subscribe((data)=>{
    this.lambdaString = data;
    console.log(data);
  })
}




}
