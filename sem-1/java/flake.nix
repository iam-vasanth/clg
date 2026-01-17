{
  description = "Beginner nix flake for Java development";

  inputs.nixpkgs.url = "github:NixOS/nixpkgs/nixos-unstable";

  outputs = { self, nixpkgs }:
  let
    system = "x86_64-linux";
    pkgs = nixpkgs.legacyPackages.${system};

    defaultJdk = pkgs.jdk;
    jdk8 = pkgs.temurin-bin-8;
  in
  {
    devShells.${system}.default = pkgs.mkShell {
      name = "Java-Shell";
      packages = with pkgs; [
        defaultJdk
        jdk8
      ];

      shellHook = ''
        echo " "
        echo "You're in Java dev shell now!"
        echo "Default (in PATH) → $(java --version | head -n1)"

        echo
        echo "Available Java commands:"
        echo "  java       → modern (${defaultJdk.version})"
        echo "  java8      → Java 8 (Temurin)"
        echo "  javac8     → Java 8 compiler"
        echo

        # Aliases
        alias java8="${jdk8}/bin/java"
        alias javac8="${jdk8}/bin/javac"
        alias jar8="${jdk8}/bin/jar"

        # Sets default JAVA_HOME
        export JAVA_HOME="${defaultJdk.home}"
      '';
    };
  };
}
