//
//  ViewController.swift
//  Flashcards
//
//  Created by Nicolas Dennis on 10/13/18.
//  Copyright © 2018 codepath. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var Front: UILabel!
    @IBOutlet weak var Back: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    @IBAction func didTapOn(_ sender: Any) {
        Front.isHidden = true;
    }

}

