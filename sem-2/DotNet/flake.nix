{
  description = "Beginner nix flake for .Net development";

  inputs = {
    nixpkgs.url = "github:NixOS/nixpkgs/nixos-unstable";
  };

  outputs = { self, nixpkgs }:
  let
    system = "x86_64-linux";
    pkgs = nixpkgs.legacyPackages.${system};
  in
  {
    devShells.${system}.default = pkgs.mkShell {
      name = ".NET-shell";

      packages = with pkgs; [
        omnisharp-roslyn
        dotnet-sdk_9
      ];
      shellHook = ''
        echo "You're in .NET dev shell now!"
      '';
    };
  };
}
