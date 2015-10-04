Listresso!
==========================



## About

## Installation

### Dependencies

#### Must haves

You'll desperately need

* [npm](www.npmjs.com)
* [Bower](www.bower.io)
* [Maven](maven.apache.org).

So go and install them for your OS. You also need a good IDE if you plan to participate to the development. *Eclipse*, *Netbeans*, *IDEA* are all fine, but please remember **not to commit** any IDE related files or folders into the VCS. Thank you. Please read the [House Rules](#houseRules) as well.

After installing the dependencies (and after you have cloned the source code, of course) you can continue with the [initial setup](#initialSetup).

#### Optionals

##### Vagrant (recommended!)

You can install [Vagrant](www.vagrantup.com) to ease the development process. There is a directory called `vagrant/` that houses all the Vagrant settings. See the [Vagrant chapter](#vagrant) for further details.

Along with Vagrant you have to install [VirtualBox](www.virtualbox.org) as the main VM host. If you want to use another VM host application (like VMWare) you need to change the file `vagrant/Vagrantfile` yourself.

##### Grunt

You can bypass the need of Vagrant and run the application using  Grunt. You can either use the MongoDB inside the Vagrant VM or you install an instance by your own.

##### MongoDB

If you completely don't want to use Vagrant and Docker, you can install MongoDB on your local machine. If you're using a local instance, you'll need Grunt for running the application, because it is not possible to pass the local MongoDB ports into the VM (Without major changes to the `Vagrantfile`. And it doesn't really make sense to do it that way, to be honest.).

##### Docker (very optional)

Since Vagrant is just a wrapping for a unified development environment, it uses [Docker](www.docker.com) to setup the atomic parts or components of the environment. You can use the Docker files directly if you want, but there are some downsides! You

* need a Linux OS
* must start the Docker containers in the right order with right arguments.

There is however a `docker_start.sh` script, the main purpose of this script is to run the docker containers *inside* the Vagrant VM. So expect some errors if you plan to run it directly on your machine.

Nevertheless, you don't have to install Docker on your developer machine at all. (Except you want to run it by yourself, of course).

### <a name="initalSetup"></a> Initial Setup

#### Windows

Install *Linux*. After that, re-read the manual. :D

Hint: This is a caveat...

#### Linux

#### Mac/Apple/iAnything

Since nobody ever uses an Apple product for real, I don't think it is necessary to write down an installation manual. No one is gonna ever read it. :D

## <a name="vagrant"></a> Vagrant

## <a name="houseRules"></a> House rules

### Project language

The project language is English all over. In VCS commits. Source code comments and documentation. `.md`'s. This includes naming the components. Simply everywhere.

## Dos and Don'ts

### Bloat folders

Please do never ever commit the folders `target/`, `node_modules/` and `src/main/webapp/bower_components/`. Those folders are ignored by default. If your IDE creates a different folder (like Netbeans `build` folder), please do not commit them. Any folder that contains compilable binary data should never be committed.

### IDE folder

Please do not commit *IDEA*'s `.idea/`, *Netbean*'s `nbproject` or *Eclipse*'s `.settings` folder nor their file doubles. Keep the project as generic and brand free as possible.
